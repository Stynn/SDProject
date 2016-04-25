package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Class use by socket to transmitt the image
 *
 */
public class Transmitter {
	
	/**
	 * Unique function of transmission
	 * @param in
	 * @param out
	 * @param closeOnExit
	 * @throws IOException
	 */
	public static void transmit(InputStream in, OutputStream out, boolean closeOnExit) throws IOException
    {
        byte buf[] = new byte[1024];
        
        int n;
        while((n=in.read(buf))!=-1)
            out.write(buf,0,n);
        
        if (closeOnExit)
        {
            in.close();
            out.close();
        }
    }
}
