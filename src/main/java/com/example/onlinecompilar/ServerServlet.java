package com.example.onlinecompilar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Server
 */

public class ServerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String editor=request.getParameter("editor");
        String customtext=request.getParameter("customtext");
        String filename=request.getParameter("filename");
        String mode=request.getParameter("mode");
        String file1 = filename.substring(filename.lastIndexOf('/') + 1);
        String withoutExt=file1.substring(0, file1.indexOf('.'));
        
        File f=new File(filename);
        
        response.addHeader("Access-Control-Allow-Origin", "*");
       
        String s=null;
        if(mode.equals("python"))
        {
        	FileOutputStream myfile = new FileOutputStream(f);
        	myfile.write(Base64.getDecoder().decode(editor.trim()));
        	myfile.close();
        	String code="python";
        	code+=new String(" ");
        	code+=filename;
        	code+=new String(" ");
            code+="2>&1";
            
            System.out.println(code);
        	try {
                
        		Process p=Runtime.getRuntime().exec(code);
                    p.waitFor();
                    BufferedReader stdInput = new BufferedReader(new 
                         InputStreamReader(p.getInputStream()));

                    BufferedReader stdError = new BufferedReader(new 
                         InputStreamReader(p.getErrorStream()));

                    // read the output from the command
                    //System.out.println("Here is the standard output of the command:\n");
                    
                    String x="";
                    	while ((s = stdInput.readLine()) != null) {
                          
                          x+=s;
                    
                    	}
                    	
                    	System.out.println(x);
                    	 // read any errors from the attempted command
                    	String y=null;
                   // System.out.println("Here is the standard error of the command (if any):\n");
                    while ((s = stdError.readLine()) != null) {
                        y+=s;
                    }
                    if(y!=null)
                    {
                    	x+=y;
                    }
                    ;
                    System.out.println("sending back.......");
                    PrintWriter writer1 = response.getWriter();
                	writer1.println(x);
                    
                    }
                    
                
                catch (IOException e) {
                    System.out.println("exception happened - here's what I know: ");
                    e.printStackTrace();
                    System.exit(-1);
                } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        if(mode.equals("java"))
        {
        	
        }
        }
	

}
