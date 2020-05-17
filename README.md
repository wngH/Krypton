## Krypton

Java based encrypter will help you in encrypting and decrypting your data in the simplest way!!

# How it work?
Until now, this project just be able to encrypt a string to a string. 

To start, at the first you need a password and a seed to encrypt and make sure your password is less longer than your data (and to dencrypt you still need both of them):

```
String target = "This is a secret message!";
target = Encrypt.encrypt(target, "Your password", "Your seed");
```
To dencrypt, re-encrypt your target, it will reveal the data:

```
String target = "This is a secret message!";
target = Encrypt.encrypt(target, "Your password", "Your seed");

// Dencrypt
target = Encrypt.encrypt(target, "Your password", "Your seed");
System.out.println(target);

```
It will be fine still if you want to protect it more carefully with more layers or encrypt data which only be able to access when all the members permit it.

```
String target = "This is a secret message!";
target = Encrypt.encrypt(target, "Password 0", "Seed 0");
target = Encrypt.encrypt(target, "Password 1", "Seed 1");
...

// Dencrypt
target = Encrypt.encrypt(target, "Password 0", "Seed 0");
target = Encrypt.encrypt(target, "Password 1", "Seed 1");
...
System.out.println(target);
// This is a secret message!
```

And finally, that 's no matter if someone know the seed but if you let someone know the password, your data will be less private and the bad guys can still guessing that. The more close seed, the more clearly your data will be displayed. Be carefull!

```
Happy hacking!
// Below case is when someone got your password and approximately correct seed, then it will output this
Happy'}7.dhE
```
