package com.openshifting.pipeline;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SampleService {

  private static Map<Long, String> sampleData = new HashMap<>();
  private static long idCounter = 1;
  // Initialize some sample data
  static {
    sampleData.put(idCounter++, "Sample 1");
    sampleData.put(idCounter++, "Sample 2");
    sampleData.put(idCounter++, "Sample 3");
  }

  public List<String> getAllSamples() {
    return new ArrayList<>(sampleData.values());
  }

  public String getSampleById(Long id) {
    return sampleData.get(id);
  }

  public String createSample(String sample) {
    sampleData.put(idCounter, sample);
    idCounter++;
    return sample;
  }

  public String updateSample(Long id, String newSample) {
    if (sampleData.containsKey(id)) {
      sampleData.put(id, newSample);
      return newSample;
    } else {
      return null;
    }
  }

  public void deleteSample(Long id) {
    sampleData.remove(id);
  }
}

