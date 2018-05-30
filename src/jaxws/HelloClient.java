package jaxws;

public class HelloClient {

	public static void main(String[] args) throws Exception {
		 HelloServiceProxy proxy = new HelloServiceProxy();
		 System.out.println(proxy.hello());

	}

}
