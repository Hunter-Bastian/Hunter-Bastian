from scapy.all import *
from scapy.layers.inet import IP, TCP
import re
"""
Important note: SET INTERFACE HERE. Otherwise, the sniffer will never find your test packets.
"""
iface = "lo"

"""
The get_login_pass function takes the TCP payload that was passed and checks the fields for common password titles
A list of usernames and password fields are initialized
A regex was given but we could not get it to work, so instead we turned our body string into a list and 
iterated through it comparing the strings directly,
If the value from the username field ever matched with the strip taken from the TCP payload, the system would write that
to the "credentials" value and move forward. 
If both the username and password fields had data, the credentials value is returned and the function returns to main
"""

def get_login_pass(body):
    bsplit = body.split()
    user = None
    passwd = None
    credentials = [None, None]
    userfields = ['login', 'user', 'uname', 'username', 'nickname', 'userid', 'login_id', 'sessionkey', 'session_key', 'uname']
    passfields = ['password', 'passphrase', 'pass', 'passwd']
    # try to find username
    for username in userfields:
        login_re = re.search('(%s=[^&]+)' % username, bsplit[0], re.IGNORECASE)
        if username == bsplit[0]:
            user = username
    # try to find password
    for password in passfields:
        login_re = re.search('(%s=[^&]+)' % password, bsplit[1], re.IGNORECASE)
        if password == bsplit[1]:
            passwd = password

    credentials = [user, passwd]
    if user and passwd:
        # return both
        return credentials

"""
The pkt_parser function is the main workhorse here.
It is designed to take the packets that are being sniffed and parse them for data.
To do this, the TCP payload has to be decoded and stored in a value. That value is passed up to the previous function
A value is returned and if that value is initialized, credentials are printed to screen. 
If the value is incomplete, the function passes and continues to wait
"""
def pkt_parser(pkt):
    try:
        if pkt.haslayer(IP) and pkt.haslayer(TCP) and pkt.haslayer(Raw):
            body = pkt[TCP].payload.load
            body = body.decode("utf-8")
            user_pass = get_login_pass(body)

            if user_pass[0] and user_pass[1]:
                print("Found Credentials:  ")
                print("\tUsername: " + user_pass[0])
                print("\tPassword: " + user_pass[1])

            # check if the return value is not empty and
                # print TCP payload
                # print(parse.unquote(variable[0])) for username
                # print(parse.unquote(variable[1])) for password

            else:
                pass
    except Exception as e:
        print(e)

"""
The main method ties all of what we have written together by starting the sniffing on the interface and 
passing data into the pkt_parser function. It can be stopped with CTRL+C
"""
def main():

    try:
        print("Standing by...")
        sniff(iface=iface, prn=pkt_parser, store=0)
    
    except KeyboardInterrupt:
        print('Exiting..')
        exit()


if __name__ == "__main__":
    main()
