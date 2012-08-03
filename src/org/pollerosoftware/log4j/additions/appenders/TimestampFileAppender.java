package org.pollerosoftware.log4j.additions.appenders;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.FileAppender;

/**
 * TimestampFileAppender allow to insert a timestamp 
 * inside the filename and the creation of a new file 
 * for each day.
 * 
 * @author Alessio Pollero
 * @version 0.9
 */
public class TimestampFileAppender extends FileAppender {
    
    private static final String TARGET = "\\{timestamp\\}";
    protected String timestampPattern = null;
    
    /**
     * Set the file name of the log file
     */
    @Override
    public void setFile(String file) {
        
    	if (timestampPattern != null) 
    		super.setFile(file.replaceAll(TARGET, new SimpleDateFormat(timestampPattern).format(Calendar.getInstance().getTime())));
		else 
			super.setFile(file);
		
    }

    /**
     * Set the file name of the log file
     * 
     * @param fileName the name of the log file
     * @param append set if it is in append mode or not
     */
    public void setFile(String fileName, boolean append, boolean bufferedIO, int bufferSize) throws IOException {
    
    	if (timestampPattern != null) 
    		super.setFile(fileName.replaceAll(TARGET, new SimpleDateFormat(timestampPattern).format(Calendar.getInstance().getTime())), append, bufferedIO, bufferSize);		
    	else 
    		super.setFile(fileName, append, bufferedIO, bufferSize);
    	
    }

    /**
     * Get the timestamp pattern in use
     * 
     * @return timestamp pattern as a string
     */
	public String getTimestampPattern() {
		return timestampPattern;
	}

	/**
	 * Set the timestamp pattern to be used
	 * 
	 * @param timestampPattern string representing the pattern
	 */
	public void setTimestampPattern(String timestampPattern) {
		this.timestampPattern = timestampPattern;
	}

}
