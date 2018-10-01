package com.etlsolutions.javafx.presentation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;

public final class DateTimePicker extends DatePicker {

    private ObjectProperty<LocalDateTime> dateTimeValue;
    private DateTimeFormatter formatter;
    private ObjectProperty<String> format;

    public DateTimePicker() {
        this("HH:mm dd-MM-yyyy");
    }

    public DateTimePicker(String formatString) {
        super();
        this.formatter = DateTimeFormatter.ofPattern(formatString);
        dateTimeValue = new SimpleObjectProperty<>(LocalDateTime.now());

        format = new SimpleObjectProperty<String>() {
            @Override
            public void set(String newValue) {
                super.set(newValue);
                DateTimePicker.this.formatter = DateTimeFormatter.ofPattern(newValue);
            }
        };

        format.setValue(formatString);
        setConverter(new InternalConverter());
        alignColumnCountWithFormat();

        valueProperty().addListener(new ChangeListener<LocalDate>() {

            @Override
            public final void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {

                if (newValue == null) {
                    DateTimePicker.this.dateTimeValue.set(null);
                } else if (dateTimeValue.get() == null) {
                    dateTimeValue.set(LocalDateTime.of(newValue, LocalTime.now()));
                } else {
                    LocalTime time = dateTimeValue.get().toLocalTime();
                    dateTimeValue.set(LocalDateTime.of(newValue, time));
                }
            }
        });

        dateTimeValue.addListener(new ChangeListener<LocalDateTime>() {

            @Override
            public final void changed(ObservableValue<? extends LocalDateTime> observable, LocalDateTime oldValue, LocalDateTime newValue) {

                if (newValue == null) {
                    setValue(null);
                    return;
                }

                LocalDate dateValue = newValue.toLocalDate();
                boolean forceUpdate = dateValue.equals(valueProperty().get());
                // Make sure the display is updated even when the date itself wasn't changed
                setValue(dateValue);
                if (forceUpdate) {
                    setConverter(new InternalConverter());
                }
            }
        });

        getEditor().focusedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public final void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    DateTimePicker.this.getEditor().commitValue();
                }
            }
        });
    }

    public void alignColumnCountWithFormat() {
        getEditor().setPrefColumnCount(getFormat().length());
    }

    public String getFormat() {
        return format.get();
    }

    public final DateTimeFormatter getFormatter() {
        return formatter;
    }

    public LocalDateTime getDateTimeValue() {
        return dateTimeValue.get();
    }

    public void setDateTimeValue(LocalDateTime dateTimeValue) {
        this.dateTimeValue.set(dateTimeValue);
    }

    public ObjectProperty<LocalDateTime> dateTimeValueProperty() {
        return dateTimeValue;
    }

    public ObjectProperty<String> formatProperty() {
        return format;
    }

    public void setFormat(String format) {
        this.format.set(format);
        alignColumnCountWithFormat();
    }

    private class InternalConverter extends StringConverter<LocalDate> {

        @Override
        public String toString(LocalDate object) {
            LocalDateTime value = getDateTimeValue();
            return (value != null) ? value.format(formatter) : "";
        }

        @Override
        public LocalDate fromString(String value) {
            if (value == null || value.isEmpty()) {
                dateTimeValue.set(null);
                return null;
            }

            dateTimeValue.set(LocalDateTime.parse(value, formatter));
            return dateTimeValue.get().toLocalDate();
        }
    }
}
