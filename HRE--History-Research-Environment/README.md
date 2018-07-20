This is a skeleton of HRE V0.1.

It includes executable programs for Linux, Mac and Windows, which reside at 

http://www.myerichsen.net/HRE/

You need to have a Java Runtime Environment installed on your system.

HRE starts with an almost empty HRE H2 database.

Troubleshooting

If you get this error:

Unresolved requirement: Require-Capability: osgi.extender

Then you need to edit the Plug-ins tab on the Run Configuration, check org.eclipse.equinox.ds and click "Add Required Plug-ins". 
