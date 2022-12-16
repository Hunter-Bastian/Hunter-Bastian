from scapy.all import *

def main():
    """
    This code was borrowed from stackoverflow and modified to meet my needs. All it does is craft and
    send a packet with Scapy. Ignore pycharm, it works fine from command line.
    Oddly enough it did seem to send twice. It may have been since we were using 127.0.0.1 as our interface, so it was
    sending and receiving it. Whatever it was, this code did it's job and we will submit it just in case.
    """
    packet = IP(dst="127.0.0.1")/TCP(dport=5555,sport=4444)/Raw('uname password')
    send(packet)
    packet.show()

"""
def packet_with_seq_n():
    packet = IP(dst="192.168.100.123", src="192.168.100.144")/TCP(sport=333, dport=222, seq=112344)/"Sequence number 112344"
    send(packet)
    # we can use sendp to choose different network interface
    sendp(packet, iface="lo")
    # lsc() can see functions descriptions.
"""
if __name__ == "__main__":
    main()
    #packet_with_seq_n()