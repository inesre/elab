package org.concord.sensor.coach.jna;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import com.sun.jna.Platform;

public abstract class LibraryBase {
	


	
	
	protected File createTmpDirectory() throws IOException {
		deleteTmpDirectory();
		File directory = File.createTempFile("jnaCMA", "");
		directory.delete();
		directory.mkdir();
		return directory;
	
    }
	protected abstract File getNativeLibraryFromJar() throws IOException, InterruptedException;
	
	
	
	
	private static String getNativeLibraryResourcePath() {
        String arch = System.getProperty("os.arch").toLowerCase();
        String osPrefix;
        if (Platform.isWindows()) {
            osPrefix = "dll";
        }
        else if (Platform.isMac()) {
            osPrefix = "darwin";
        }
        else if (Platform.isLinux()) {
            if ("x86".equals(arch)) {
                arch = "i386";
            }
            else if ("x86_64".equals(arch)) {
                arch = "amd64";
            }
            osPrefix = "linux_" + arch;
        }
        else if (Platform.isSolaris()) {
            osPrefix = "sunos_" + arch;
        }
        else {
            osPrefix = System.getProperty("os.name").toLowerCase();
            int space = osPrefix.indexOf(" ");
            if (space != -1) {
                osPrefix = osPrefix.substring(0, space);
            }
            osPrefix += "-" + arch;
        }
        return "/org/concord/sensor/coach/jna/" + osPrefix;
    }
	
	
	
	//Init
	 protected File extractResource(String resourceName, File directory) throws Error, FileNotFoundException {
		String resourcePath = getNativeLibraryResourcePath() + "/" + resourceName;
		URL url = CoachLibrary.class.getResource(resourcePath);

		if (url == null) {
			throw new FileNotFoundException(resourceName + " not found in resource path");
		}

		File resourceFile = null;
		InputStream is = CoachLibrary.class.getResourceAsStream(resourcePath);
		if (is == null) {
			throw new Error("Can't obtain resource InputStream, resource: " + resourcePath);
		}

		FileOutputStream fos = null;
		try {
			String fileName = resourceName.substring(resourceName.lastIndexOf('/')+1);
			resourceFile = new File(directory, fileName);
			fos = new FileOutputStream(resourceFile);
			int count;
			byte[] buf = new byte[1024];
			while ((count = is.read(buf, 0, buf.length)) > 0) {
				fos.write(buf, 0, count);
			}
		}
		catch(IOException e) {
			throw new Error("Failed to create temporary file: " + e);
		}
		finally {
			try { is.close(); } catch(IOException e) { }
			if (fos != null) {
				try { fos.close(); } catch(IOException e) { }
			}
		}
		return resourceFile;
	}

	
	
	
	 protected static class NativeHelper {
	    	protected static void deleteNativeLibrary(File file) {
	    		if (file.delete()) {
	    			return;
	    		}
	    		markTemporaryFile(file);
	    	}

	    	private static void markTemporaryFile(File file) {
	    		try {
	    			File marker = new File(file.getParentFile(), file.getName() + ".x");
	    			marker.createNewFile();
	    		}
	    		catch(IOException e) { e.printStackTrace(); }
	    	}

	    	protected static void removeTemporaryFiles() {
	    		File dir;
	    		try {
	    			dir = File.createTempFile("jna", ".x").getParentFile();
	    			FilenameFilter filter = new FilenameFilter() {
	    				public boolean accept(File dir, String name) {
	    					return name.endsWith(".x") && name.indexOf("jna") != -1;
	    				}
	    			};
	    			File[] files = dir.listFiles(filter);
	    			for (int i=0;files != null && i < files.length;i++) {
	    				File marker = files[i];
	    				String name = marker.getName();
	    				name = name.substring(0, name.length()-2);
	    				File target = new File(marker.getParentFile(), name);
	    				if (!target.exists() || target.delete()) {
	    					marker.delete();
	    				}
	    			}
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    }
	 
		public void deleteDirectory(File file){
			File[] files = file.listFiles();

			if(files!=null){

				for(File f : files){

					if(f.isDirectory()) deleteDirectory(f);
					else f.delete();
					if(f.exists()) f.deleteOnExit();
				}
			}
			file.delete();
		}
		
		public void deleteTmpDirectory(){
			File file;
			try {
				file = File.createTempFile("jnaCMA", "").getParentFile();
			
				File[] files = file.listFiles();
	
				if(files!=null){
	
					for(File f : files){
	
						if(f.isDirectory()) if ((f.getName()).startsWith("jnaCMA")) deleteDirectory(f);
						f.delete();
					}
				}
		
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	 
}
