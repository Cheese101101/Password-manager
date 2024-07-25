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

When you request for a websites password and username you are not required to type the full name of the website, you can search a keyword/letter/sequence of words from the title which will result in a list of all websites recorded containing the input.
From there you can re-enter the website you want and you will get your information.
Note however that the website name must contain the search input correctly otherwise it will not appear as a result, therefore it is best to keep the search input vague if you are unsure.

Also note that the terminal will only ask for the pin once, and once the user has gained access to the menu they will not need to re-enter the pin until the program is rerun.
The terminal will not ask for a pin however, if there is no pin set previously.
# Storage
This is the text file which will store all the data including the websites information and your pin.
# Encryptor
This module is made to encrypt and decrypt and text given. 
I have used this to encrypt the storage text file so that you may not access the files contents outside of the program itself.
The text file is decrypted at the beginning of the program and re-encrypted at the end.
The cipher I have used in this code is quite simple, it will shift every character apart from spaces by +5 char value, this method can be made more rigourous to ensure higher level of safty however for the purpose of my program I have chosen to leave it at a low security level.
