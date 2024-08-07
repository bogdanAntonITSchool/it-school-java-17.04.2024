package ro.itschool.testcontroller.controller.payload;

import lombok.Builder;

@Builder
public record ResponsePayload<T>(T data, String message) {
}
