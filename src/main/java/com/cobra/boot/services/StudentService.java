package com.cobra.boot.services;

import java.util.List;
import java.util.Map;

public interface StudentService {
  List<Map<String,Object>> findStudentAndClass(Integer cid);
}
