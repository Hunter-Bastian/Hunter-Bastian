import hashlib
"""
There is not much of a need to put docstrings in every function here. 
First, the program accepts text input for a hash type, location of a wordlist, and the hash to the password
itself.
Next, the "with" statements opens the file for reading
A series of if statements check for which type of hash is present
Within those if statements, a for loop hashes each line and compares it to the given hash. 
If they are ever equal, the system prints to console and exits. 
Otherwise, the system prints that no password was found. 
"""
# prompt the user to input hash type
htype = input("Please input a hash type: ")
# prompt the user to input a file having the password list
filename = input("Please input a wordlist location: ")
# prompt the user to input the hashed password to crack
phash = input("Please input the hash of the password you'd like to crack: ")
# with the password file open, read each line
with open(filename, 'r') as file:
    # if the hash type is md5:
    if htype == "md5":
        for line in file:
            # create a variable storing hashlib.md5(line.strip().encode()).hexdigest()
            hstore = hashlib.md5(line.strip().encode()).hexdigest()
            # if it matches the hashed password the user entered, print("password found" + line.strip())
            if hstore == phash:
                print("Password Found: " + line.strip())
                exit(0)
                # exit
    # repeat the same with hash type sha1
    # replace hashlib.md5 with hashlib.sha1
    elif htype == "sha1":
        for line in file:
            hstore = hashlib.sha1(line.strip().encode()).hexdigest()
            # if it matches the hashed password the user entered, print("password found" + line.strip())
            if hstore == phash:
                print("Password Found: " + line.strip())
                exit(0)
    # print('Password not in file') if none of the password matches
    else:
        print("Password not in file.")
        exit(0)
