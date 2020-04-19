package com.techievibe.server.common;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomerDateAndTimeDeserialize extends JsonDeserializer<Date> {

	private static final Logger LOG = LogManager.getLogger(CustomerDateAndTimeDeserialize.class);

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
			throws IOException, JsonProcessingException {
		String str = paramJsonParser.getText().trim();
		try {
			LOG.info("CustomerDateAndTimeDeserialize >>> str : " + str);
			LOG.info("CustomerDateAndTimeDeserialize >>>dateFormat.parse(str) : " + dateFormat.parse(str));
			return dateFormat.parse(str);
		} catch (ParseException e) {
			// Handle exception here
			LOG.info("CustomerDateAndTimeDeserialize >>> : " + e);
		}
		return paramDeserializationContext.parseDate(str);
	}

}
