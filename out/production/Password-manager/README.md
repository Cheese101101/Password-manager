# Password-manager
This model will store all your passwords and usernames for different websites. You are able to add, get and replace information for your different accounts.
It will store all your information into a text file in your preferred location so that the data is not lost after restarting the program.
The program can also generate a random password of a given length which will include a mix of alphanumeric and symbols, this is so that the password may pass most parameters a website might require you to have.
I have also implemented a pin system at the beginning of the program since you will be accessing sensitive information
I have used a few modules for this each with unique purpose.
# Files
The files class has all methods that are related to transferring data to and from the text file which will store your data.
This class is mainly useful if you intend to store the data for ongoing use and not a one time use.
I've implemented the methods from this class in the class 'Website' the most and in 'Front Interface', therefore this class is necessary to be able to use the following classes.
# Website
This class is mainly useful in creating a 'Website' object so that storing and adding information is a lot more easier and organised.
Each object has 3 attributes (website name, password, username) which can be called and found through the relevant methods.
You may also set the attributes using the given methods.
# FrontInterface
This class is what handles the interface that the user will be using.
It uses a basic menu accessed through a pin to give the user options of what they want to do.
Each option may have a follow up menu which the user can further choose from and then the option will be executed using the previous two classes.
Note that once the terminal will only ask for the pin once, and once the user has gained access to the menu they will not need to re-enter the pin until the program is rerun.
The terminal will not ask for a pin however is there is no pin set previously.
# Storage
This is the text file which will store all the data including the websites information and your pin.