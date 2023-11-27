## Acceso a correo por POP
[Proyecto s05.popemail]

Spring también permite el acceso a los buzones de correo a través del protocolo POP. POP permite conectarse a un servidor para descargarse los correos recibidos. A diferencia de IMAP, POP elimina los correos una vez leídos (salvo que se le diga lo contrario), y no mantiene una estructura de carpetas en el buzón.
Al margen de la idoneidad de un protocolo u otro, basta con saber que también tenemos esta posibilidad disponible y que su uso es prácticamente igual que con IMAP.

El cliente POP tiene un canal específico para recibir mensajes que le inyectaremos en la configuración, además de dos métodos: uno para los nuevos mensajes y otro para ir mostrando los mensajes que ya existen en el buzón.


**Listado - Fichero PopClient.java.**

```java

public class PopClient {
  
  private DirectChannel receiveEmailChannel;

  public void subscribeToNewMessages () {
    receiveEmailChannel.subscribe(new MessageHandler() {
      @Override
      public void handleMessage(Message<?> message) throws MessagingException {
        System.err.println("********** NEW MESSAGE *************");
        System.err.println("Message: " + message);
        System.err.println("************************************");
      }
    });
  }
  
  public void receive(MimeMessage message) throws Exception {
    System.out.println("*********************************");
    System.out.println("Id: " + message.getMessageID());
    System.out.println("From: " + Arrays.toString(message.getFrom()));
    System.out.println("To: " + Arrays.toString(message.getAllRecipients()));
    System.out.println("Subject: " + message.getSubject().toString());
    System.out.println("**********************************");
  }

  
  public DirectChannel getReceiveEmailChannel() {
    return receiveEmailChannel;
  }

  public void setReceiveEmailChannel(DirectChannel receiveEmailChannel) {
    this.receiveEmailChannel = receiveEmailChannel;
  }


}
```

En este caso se vuelve a aplicar la configuración por xml. Se utilizan espacios de nombres específicos de email y otros utilidades y obviamente, se debe configurar la cuenta POP correctamente. El ejemplo muestra la configuración para una cuenta de Gmail.
Al igual que con el ejemplo de imap, el acceso a la cuenta se hace pasar por un canal al que suscribiremos el bean y del que se sacaran los mensajes. 

**Listado - Fichero beans.xml.**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
  xmlns:mail="http://www.springframework.org/schema/integration/mail"
  xmlns:int="http://www.springframework.org/schema/integration"
  xmlns:util="http://www.springframework.org/schema/util"
  xsi:schemaLocation="http://www.springframework.org/schema/beans 
            http://www.springframework.org/schema/beans/spring-beans.xsd
                  http://www.springframework.org/schema/integration/mail
                  http://www.springframework.org/schema/integration/mail/spring-integration-mail.xsd 
                  http://www.springframework.org/schema/util 
                  http://www.springframework.org/schema/util/spring-util.xsd">


  <util:properties id="javaMailProperties">
    <prop key="mail.pop3.socketFactory.fallback">false</prop>
    <prop key="mail.debug">true</prop>
    <prop key="mail.pop3.port">995</prop>
    <prop key="mail.pop3.socketFactory.class">javax.net.ssl.SSLSocketFactory</prop>
    <prop key="mail.pop3.socketFactory.port">995</prop>
  </util:properties>

  <mail:inbound-channel-adapter id="customAdapter"
    store-uri="imaps://[username]:[password]@imap.gmail.com:993/inbox"
    channel="inputChannel" 
    should-delete-messages="false"
    should-mark-messages-as-read="false" 
    java-mail-properties="javaMailProperties">
    <int:poller fixed-rate="1000" max-messages-per-poll="1" />
  </mail:inbound-channel-adapter>


  <int:channel id="inputChannel" />
  <int:channel id="receiveEmailChannel" />
  <mail:mail-to-string-transformer
    input-channel="inputMail" output-channel="receiveEmailChannel" />


  <bean id="popClient" class="es.anaya.spring.services.s05.popemailxml.PopClient">
    <property name="receiveEmailChannel" ref="receiveEmailChannel" />
  </bean>
  <int:service-activator input-channel="receiveEmailChannel"
    ref="popClient" method="receive" />
</beans>
```

El fichero principal, al igual que en el ejemplo de imap, carga el bean de cliente POP y se suscribe a la recepción de nuevos mensajes. De forma automática se observará como el bean se conecta a la cuenta y se empiezan a ver los correos.

**Listado - Fichero Application.java.**

```java
@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    PopClient popClient = (PopClient) context.getBean("mailman");
    popClient.subscribeToNewMessages();
  }

}
```
