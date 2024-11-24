package FrameworkDesign.FunctionalTestData;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	
	public List<HashMap<String, String>> getJsonDatatoMap() throws IOException {
		
//		Capturing the JSON data :-
		
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//FrameworkDesign//FunctionalTestData//FunctionalTestData.json"), StandardCharsets.UTF_8);
		System.out.println(jsonContent);
		
//		Convert String to HashMap :- (jackson data bind)
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String, String>> data =  mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		
		return data;
	}
}
