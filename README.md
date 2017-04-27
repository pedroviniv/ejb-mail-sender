# ejb-mail-sender

Before build and deploy the project you should create a few resources
on your server.

**I'm using the resources below:**
- javax.jms.ConnectionFactory "jms/dac/dacConnectionFactory"
- javax.jms.Queue named "jms/dac/newEmailsQueue"
- javax.jms.Queue named "jms/dac/waitingEmailsQueue"
- javax.mail.Session "javamail/javaMailSession"

To create these on your glassfish/payara server you must 
open your terminal and put the following commands:

- To create javax.jms.ConnectionFactory "jms/dac/dacConnectionFactory":
	- `asadmin create-jms-resource --restype javax.jms.ConnectionFactory jms/dac/dacConnectionFactory`

- To create javax.jms.Queue named "jms/dac/newEmailsQueue":
	- `asadmin create-jms-resource --restype javax.jms.Queue jms/dac/newEmailsQueue`

- To create javax.jms.Queue named "jms/dac/waitingEmailsQueue":
	- `asadmin create-jms-resource --restype javax.jms.Queue jms/dac/waitingEmailsQueue`

- To create javax.mail.Session "javamail/javaMailSession":
	- `asadmin create-javamail-resource --mailhost="smtp.gmail.com" --mailuser="GMAIL_USER" --fromaddress="GMAIL_ADDRESS" --debug="false" --enabled="true" --description="A new JavaMail Session!" --property="mail.smtp.password=GMAIL_PASSWORD:mail.smtp.auth=true:mail.smtp.port=465:mail.smtp.socketFactory.fallback=false:mail.smtp.socketFactory.port=465:mail.smtp.socketFactory.class=javax.net.ssl.SSLSocketFactory" "javamail/javaMailSession"`

### Building

To build the application just...
- download as a zip file or clone this repository by running `git clone https://github.com/pedroviniv/ejb-mail-sender.git`
- run `mvn clean install` 
