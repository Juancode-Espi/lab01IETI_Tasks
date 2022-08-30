package com.lab01IETI.task.entities;

public enum Status {
    TODO{
        @Override
        public String asLowerCase(){
            return TODO.toString().toLowerCase();
        }
    },
    DOING{
        @Override
        public String asLowerCase(){
            return DOING.toString().toLowerCase();
        }
    },
    REVIEW{
        @Override
        public String asLowerCase() {
            return REVIEW.toString().toLowerCase();
        }
    },
    DONE {
        @Override
        public String asLowerCase() {
            return DONE.toString().toLowerCase();
        }
    };
    public abstract String asLowerCase();
}
