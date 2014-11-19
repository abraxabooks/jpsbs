jpsbs
=====

Java Programming Step-by-Step - book source code

This repositpry contains the source code for the book, and is comprised of the two NetBeans projects called Utilities and VirtualZoo. The VirtualZoo application makes use of both the Utilities project and the Java Look and Feel Graphic Repository for its toolbar and menubar icons. For licensing reasons you will need to separately download the graphics repository. The steps below will guide you in the process of setting up the source files:


1. Extract the contents of this ZIP file to a convenient location on your system.

2. Launch NetBeans (requires at least version 7) and select File | Open Project...

3. Browse to the location where you extracted the Utilities project and select it.

4. Select File | Open Project... again and this time select the VirtualZoo project.

5. A dialogue will appear stating that some references could not be found. This is referring to the fact that it needs to be linked to the Utilities project, so click the button marked Resolve Problems... and on the next dialogue click the button marked Resolve...

6. Browse to the location of the Utilites project and select it. The bottom area of the dialogue should now state that the problem has been resolved, so click Cancel.

7. To obtain and setup the Java Look and Feel Graphic Repository follow the instructions on pages 453 and 454 of the book, down to and including the grey notebox where it asks you to perform a Clean and Build.

8. Right-click on the VirtualZoo project node in the Projects window and select Set as Main project.

9. If when you try to run the application you get a message that there is no default class then select VirtualZoo.java from the virtualzoo package.


You should also periodically check for any errata for the book on our website:
http://www.abilityfirst.co.uk/books


All source code is provided AS-IS without any warranty of any kind.
You may not re-publish the source by any means, including posting on the Internet.

Copyright 2012, Ability First Limited.
