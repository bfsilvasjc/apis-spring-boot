package com.teste.tecnico2.teste2.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BubbleService {

	public List<Integer> sort(List<Integer> list) {
		int n = list.size();
	    int temp = 0;

	    for (int i = 0; i < n - 1; i++) {
	        for (int j = 0; j < (n - i - 1); j++) {
	            if (list.get(j) > list.get(j+1)) {
	                temp = list.get(j);
	                list.set(j,list.get(j+1));
	                list.set(j+1, temp);
	            }
	        }
	    }
	    return list;
	}
}
