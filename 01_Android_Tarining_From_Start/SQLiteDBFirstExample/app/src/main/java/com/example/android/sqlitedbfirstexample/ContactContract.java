package com.example.android.sqlitedbfirstexample;

public final class ContactContract {

    private ContactContract() {
    }

    public static class ContactEntry {
        public static final String TABLE_NAME = "contactinfo";
        public static final String CONTACT_ID = "contactid";
        public static final String NAME = "name";
        public static final String EMAIL = "email";

    }
}
