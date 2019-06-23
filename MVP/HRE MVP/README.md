This project is an attempt to sketch a minimum viable product using the philosophy of the HRE data model in an extremely reduced form.
It is intended to grow into an HRE implementation, if possible.

Executable versions for Windows (32 and 64 bit), Linux (32 and 64 bit) and Mac can be downloaded from http://www.myerichsen.net/HRE/, which also holds installation instructions.

Once installed, the product can update itself over the Internet from the update site at http://www.myerichsen.net/HRE/repository using a menu item in the product. Note: This does not work yet!

Architecture principles:

There are many-to-many relations everywhere that HRE needs it. Such as gender changes, concurrent name variants, multiple partners etc. This is not a moral decision, but based on real life facts.

The technology model is based on
* Java
* Eclipse E4
* SWT and JFace
* JSON
* H2 database
* Open source

The application has a layered infrastructure model. It can run as
* Stand-alone application
* Client with a remote server
* Server with a UI
* Headless server

This is prepared for, but not yet implemented.

The class model is layered accordingly.

The server part contains a database access class and a server class for each table and GUI part. The database access class is not directly accessible from the client, which must use the server class.

The client part contains a GUI part (Eclipse E4, SWT and JFace) and a provider class. The provider class is the interface to the server class. It is currently using a direct method call, but is prepared for switching to a JSON call over TCP/IP.