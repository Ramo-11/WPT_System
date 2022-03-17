all: Classes Frames Panels Buttons Main.class

Main.class:
	javac -g Main.java

Buttons:
	javac -g GUI/Buttons/*.java

Labels:
	javac -g GUI/Labels/*.java

Panels:
	javac -g GUI/Panels/*.java

Frames:
	javac -g GUI/Frames/*.java

Classes:
	javac -g Classes/*.java

run: all
	java Main

jar: all
	jar cfm WPT.jar manifest.txt *.class GUI/Buttons/*.class GUI/Labels/*.class GUI/Panels/*.class GUI/Frames/*.class Classes/*.class

clean:
	rm *.class
	rm GUI/Buttons/*.class
	rm GUI/Labels/*.class
	rm GUI/Panels/*.class
	rm GUI/Frames/*.class
	rm Classes/*.class
	rm *.jar