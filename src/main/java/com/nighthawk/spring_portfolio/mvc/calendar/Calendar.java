package com.nighthawk.spring_portfolio.mvc.calendar;

import java.time.Duration;
import java.time.LocalDateTime;

public class Calendar {
    private CalendarEvent head;

    public void addEvent(CalendarEvent event) {
        if (head == null) {
            head = event;
        } else {
            CalendarEvent current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(event);
        }
    }

    public CalendarEvent findEventWithinTime(LocalDateTime referenceDate, Duration duration) {
        if (head == null) {
            return null;
        }

        // Calculate the end time based on the reference date and duration
        LocalDateTime endDate = referenceDate.plus(duration);

        // Traverse the linked list to find the first event that starts after or at the end time
        CalendarEvent current = head;
        while (current != null && current.getStartTime().isBefore(endDate)) {
            current = current.getNext();
        }

        return current; // Return the first event found within the specified duration
    }

    public CalendarEvent getHead() {
        return head;
    }

    public void setHead(CalendarEvent head) {
        this.head = head;
    }
}
