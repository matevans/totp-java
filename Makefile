
# Generate a TOTP code
generate : TOTP.class totp.jar commons-codec.jar
	java -cp ./:commons-codec.jar:totp.jar TOTP $(SECRET)

clean :
	rm *.jar
	rm *.class

# Compile Java
TOTP.class : TOTP.java totp.jar commons-codec.jar
	javac -cp ./:commons-codec.jar:totp.jar TOTP.java

# Get TOTP dependency
totp.jar:
	wget -q https://search.maven.org/remotecontent?filepath=dev/samstevens/totp/totp/1.7.1/totp-1.7.1.jar -O totp.jar

# Get Apache Commons Codec dependency
commons-codec.jar:
	wget -q https://search.maven.org/remotecontent?filepath=commons-codec/commons-codec/1.15/commons-codec-1.15.jar -O commons-codec.jar

