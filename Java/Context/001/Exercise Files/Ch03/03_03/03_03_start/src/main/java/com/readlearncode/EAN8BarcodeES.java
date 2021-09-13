package com.readlearncode;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Barcode(type = Barcode.Type.EAN8)
public class EAN8BarcodeES implements CodeGenerator {
    @Override
    public String generateCode() {
        return "EAN8: 94184600";
    }
}