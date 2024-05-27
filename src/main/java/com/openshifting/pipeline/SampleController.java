package com.openshifting.pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SampleController {

  @Autowired
  private SampleService sampleService;

  @GetMapping("/samples")
  public ResponseEntity<List<String>> getAllSamples() {
    List<String> samples = sampleService.getAllSamples();
    return new ResponseEntity<>(samples, HttpStatus.OK);
  }

  @GetMapping("/samples/{id}")
  public ResponseEntity<String> getSampleById(@PathVariable("id") Long id) {
    String sample = sampleService.getSampleById(id);
    if (sample != null) {
      return new ResponseEntity<>(sample, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/samples")
  public ResponseEntity<String> createSample(@RequestBody String sample) {
    String createdSample = sampleService.createSample("This is a pipeline");
    return new ResponseEntity<>(createdSample, HttpStatus.CREATED);
  }


  @DeleteMapping("/samples/{id}")
  public ResponseEntity<Void> deleteSample(@PathVariable("id") Long id) {
    sampleService.deleteSample(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}


