package a;

public class Phone implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("phone closed");
	}

}
