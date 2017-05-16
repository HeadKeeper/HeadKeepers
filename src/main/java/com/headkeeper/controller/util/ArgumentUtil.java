package com.headkeeper.controller.util;

import com.headkeeper.controller.exception.ControllerException;
import com.headkeeper.service.exception.ServiceException;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ArgumentUtil {
    public static String generatePass(String pass) throws ControllerException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update("salad".getBytes("UTF-8"));
            byte[] bytes = md.digest(pass.getBytes("UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            pass = stringBuilder.toString();
            return pass;
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new ControllerException("Cannot perform action with parameters");
        }
    }
}
