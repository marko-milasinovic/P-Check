package fileOperators;

import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public final class MyFileUtils {
	private static AtomicInteger counter = new AtomicInteger(0);
	
	public static boolean customSearchForFiles(Map<String, Integer> dirs, String searchDir, int depth){
		if(depth < 1){
			return true;
		}
		--depth;
		System.out.println(counter.incrementAndGet());
		try {
			File rootFile = new File(searchDir);
			if( !(rootFile != null && rootFile.isDirectory())){
				return false;
			}
			File[] rootDirectories = rootFile.listFiles();
			if( !(rootDirectories != null && rootDirectories.length > 1)){
				return false;
			}
			for(File testFile : rootDirectories) {
				if(!testFile.isDirectory()){
					continue;
				}
				String testKey = testFile.getName().toLowerCase(Locale.ROOT);
				Integer returnValue = dirs.get(testKey);
				if (returnValue != null) {
					dirs.put(testKey, 1);
					continue;
				}
				customSearchForFiles(dirs,testFile.getPath(),depth);
			}
		}catch(Exception e){
			System.out.println("Error while searching, " + e.getLocalizedMessage());
			return false;
		}
		
		return true;
	}
	
	
	
	// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	// Public methods
	//
	public static final String searchDirForFile(String dir, String fileName) {
		File[] files = new File(dir).listFiles();
		for(File f:files) {
			if(f.isDirectory()) {
				String loc = searchDirForFile(f.getPath(), fileName);
				if(loc != null)
					return loc;
			}
			if(f.getName().equals(fileName))
				return f.getPath();
		}
		return null;
	}
	
	
	public static final boolean createFileIfNotExists(String dir) {
		try {
			File f = new File(dir);
			f.getParentFile().mkdirs();
			
			if(!f.exists()) {
				f.createNewFile();
			}
		}
		catch(Exception e){
			System.out.println("Exception while writing file!" + e.getLocalizedMessage());
			return false;
		}
		return true;
	}
	
	
	
		
	public static final boolean hasFileReadWritePermissions(String dir){
		try {
			File file = new File(dir);
			
			return (file.canWrite() && file.canRead());
		}catch (Exception e){
			return false;
		}
	}
	
	
	
	// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	// Private constructor so that the static class cant be created
	//
	private MyFileUtils(){ }
}
