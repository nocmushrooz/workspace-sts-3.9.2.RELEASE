package com.fdmgroup.Comparator;

import java.util.Comparator;

import com.fdmgroup.Message.Message;

public class DateComparator implements Comparator<Message> {

	@Override
	public int compare(Message o1, Message o2) {
		
		return o1.getDateNTime().compareTo(o2.getDateNTime());
	}

}
