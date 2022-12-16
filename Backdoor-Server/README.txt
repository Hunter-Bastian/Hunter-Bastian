**A project showcasing a server to backdoor connection with a handful of functionalities.**

The connection relies on both the server and backdoor running. If one program exits, the other exits as well.

Commands may be entered from the server-side and they will be executed within a shell on the backdoor machine,
	This is for the most part universal across both windows and linux, however specifically the command to change directories "cd " is only written for linux

Keylogger functionality is included with a small handful of commands.

	'keylog_start' will boot up the keylogger on the backdoor side. Keystrokes are saved in directories that are dependent on the target OS. See comments for details
	'keylog_dump' will retrieve the saved keystrokes and save them onto the server machine in a file whos directory is dependent on the hosting os. See comments.
	'keylog_stop' will halt the keylogger and delete the current repository of saved keylogs. The keylogger may be restarted after this operation.

The included keylogger must be in the same directory as the backdoor. They are included as seperate packages.

The command 'quit' will terminate the server and the backdoor.


***	Current configuration     ***

IP is set to loopback for both devices
	The only IP required for this connection is the server's ipv4. Replace the IP variables in both Server.py and Backdoor.py
