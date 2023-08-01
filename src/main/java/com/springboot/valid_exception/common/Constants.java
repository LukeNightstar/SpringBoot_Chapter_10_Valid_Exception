package com.springboot.valid_exception.common;

public class Constants {

    public enum ExceptionClass{

        // 상수 하나 선언(도메인 Product 엔티티로만 실습한 관계로)
        PRODUCT("Product");

        private String exceptionClass;

        ExceptionClass(String exceptionClass) {
            this.exceptionClass = exceptionClass;
        }

        public String getExceptionClass() {
            return exceptionClass;
        }
        @Override
        public String toString() {
            return getExceptionClass() + " Exception. ";
        }
    }

}
