/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import exception.FileNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author steph18
 */
@ApplicationScoped
@Transactional
public class MailTemplateService {

    private static final Logger LOGGER = Logger.getLogger(MailTemplateService.class.getName());

    private static final Pattern VAR_PATTERN = Pattern.compile("\\[(\\w+)\\]");

    public String processTemplate(String templateName, Map<String, String> variables) throws IOException {
        String templateContent = this.loadTemplate(templateName);
        return this.replaceVariables(templateContent, variables);
    }

    private String loadTemplate(String templateName) throws IOException {
        String path = "templates/mail/" + templateName;
        LOGGER.log(Level.INFO, "Load template path: {0}", path);
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream(path);
        if (Objects.isNull(stream)) {
            LOGGER.log(Level.INFO, "InputStream null");
            throw new FileNotFoundException("File not found " + path);
        }
        LOGGER.log(Level.INFO, "Reading file load successfully");
        return new String(stream.readAllBytes(),
                StandardCharsets.UTF_8);
    }

    private String replaceVariables(String templateContent, Map<String, String> variables) {
        LOGGER.log(Level.INFO, "Replace variables starting...");
        Matcher matcher = VAR_PATTERN.matcher(templateContent);
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            String key = matcher.group(1);
            String replace = variables.getOrDefault(key, "");
            matcher.appendReplacement(result, replace);
        }
        matcher.appendTail(result);
        LOGGER.log(Level.INFO, "Replace variables ending...");
        return result.toString();
    }

}
