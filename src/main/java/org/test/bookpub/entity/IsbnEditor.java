package org.test.bookpub.entity;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

/**
 * It is VERY important to know that PropertyEditor is not thread safe!
 *
 * Mostly because of its statefulness and lack of thread safety,since version 3, Spring has added a Formatter interface
 * as a replacement for PropertyEditor.The Formatters are intended to provide a similar functionality but in a
 * completely thread-safe manner and focusing on a very specific task of parsing a String in an object type and
 * converting an object to its String representation.
 *
 * THEREFORE THERE SHOULD BE NO NEED TO FOLLOW THIS EXAMPLE?
 */


public class IsbnEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.hasText(text)) {
            setValue(new Isbn(text.trim()));
        } else {
            setValue(null);
        }
    }

    @Override
    public String getAsText() {
        Isbn isbn = (Isbn) getValue();
        if (isbn != null) {
            return isbn.getIsbn();
        } else {
            return "";
        }
    }
}
