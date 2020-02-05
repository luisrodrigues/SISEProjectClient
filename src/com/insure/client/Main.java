package com.insure.client;

import com.insure.client.gen.*;
import cryptography.Signature;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import javax.xml.ws.BindingProvider;
import java.awt.*;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

//Wsimport.bat -s ..\src -keep -p com.insure.client.gen "http://localhost:8090/claimservice?wsdl"

public class Main {
    public static final String INSERT_CLAIM_ID = "Insert claim id: ";
    public static final String INSERT_DOCUMENT_ID = "Insert document id: ";

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException {

            Signature signature = new Signature();
            String url = "http://localhost:8090/claimservice";
            ClaimDataStoreService dss = new ClaimDataStoreService();
            //docStorage -> Claim data store
            ClaimDataStore docStorage = dss.getClaimDataStorePort();
            ((BindingProvider) docStorage).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

            // Client code
            String userId = JOptionPane.showInputDialog("Insert username: ", "user1");
            //client action variables
            String[] options = {"create claim", "create document", "read document", "list documents",
                    "simulate document tampering", "exit"};
            // main state variable
            boolean isRunning = true;

        while (isRunning) {
            String expression = (String)JOptionPane.showInputDialog(null, "Insert your action:",
                    "You are " + userId, JOptionPane.QUESTION_MESSAGE, null, options, options[5]);

                switch (expression) {
                    case "create claim":

                        createClaimClient(docStorage, userId);
                        break;

                    case "create document":

                        createDocumentClient(signature, docStorage, userId);
                        break;

                    case "read document":

                        readDocumentClient(docStorage);


                        break;
                    case "list documents":

                        listDocumentsClient(docStorage);
                        break;

                    case "simulate document tampering":

                        simulateDocumentTamperingClient(signature, docStorage, userId);
                        break;

                    case "exit":

                        isRunning = false;
                        break;

                    default:
                        break;
                }
        }

    }

    private static void simulateDocumentTamperingClient(Signature signature, ClaimDataStore docStorage, String userId) {

        int claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
        String documentContent = JOptionPane.showInputDialog("Insert document content: ");


        try {
            String digitalSignature = signature.generate(documentContent, "keys/" + userId +
                    "PrivateKey");
            int documentId = docStorage.createDocumentOfClaim(claimId, documentContent +
                    "this has been tampered", userId, digitalSignature);
            JOptionPane.showMessageDialog(null, docStorage.readDocumentOfClaim(claimId,
                    documentId));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | HeadlessException |
                DocumentNotFoundException_Exception | IOException | BadPaddingException | InvalidKeyException
                | IllegalBlockSizeException | BadPaddingException_Exception | ClaimNotFoundException_Exception
                | IOException_Exception | IllegalBlockSizeException_Exception | InvalidKeyException_Exception
                | InvalidKeySpecException_Exception | InvalidSignatureException_Exception
                | NoSuchAlgorithmException_Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void listDocumentsClient(ClaimDataStore docStorage) {
        int claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));


        try {
            printElements(docStorage.listDocumentsOfClaim(claimId).toArray(new String[0]));
            JOptionPane.showMessageDialog(null, "Output in the terminal");
        } catch (BadPaddingException_Exception | ClaimNotFoundException_Exception | IOException_Exception
                | IllegalBlockSizeException_Exception | InvalidKeyException_Exception
                | InvalidKeySpecException_Exception | InvalidSignatureException_Exception
                | NoSuchAlgorithmException_Exception | HeadlessException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void readDocumentClient(ClaimDataStore docStorage) {
        int claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
        int documentId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_DOCUMENT_ID));


        try {
            JOptionPane.showMessageDialog(null, docStorage.readDocumentOfClaim(claimId,
                    documentId));
        } catch (BadPaddingException_Exception | ClaimNotFoundException_Exception
                | DocumentNotFoundException_Exception | IOException_Exception | IllegalBlockSizeException_Exception
                | InvalidKeyException_Exception | InvalidKeySpecException_Exception
                | InvalidSignatureException_Exception | NoSuchAlgorithmException_Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void createDocumentClient(Signature signature, ClaimDataStore docStorage, String userId) {
        int claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
        String documentContent = JOptionPane.showInputDialog("Insert document content: ");


        try {
            String digitalSignature = signature.generate(documentContent, "keys/" +
                        userId + "PrivateKey");

            int documentId = docStorage.createDocumentOfClaim(claimId, documentContent, userId,
                            digitalSignature);
            JOptionPane.showMessageDialog(null, docStorage.readDocumentOfClaim(claimId,
                        documentId));
        } catch (NoSuchAlgorithmException | IOException | InvalidKeySpecException | BadPaddingException
                | InvalidKeyException | IllegalBlockSizeException | BadPaddingException_Exception
                | ClaimNotFoundException_Exception | IOException_Exception | IllegalBlockSizeException_Exception
                | InvalidKeyException_Exception | InvalidKeySpecException_Exception
                | InvalidSignatureException_Exception | NoSuchAlgorithmException_Exception
                | DocumentNotFoundException_Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void createClaimClient(ClaimDataStore docStorage, String userId) {
        String claimDescription = JOptionPane.showInputDialog("Insert claim description: ");
        int claimId = docStorage.createClaim(claimDescription, userId);

        try {
            JOptionPane.showMessageDialog(null, docStorage.printClaim(claimId));
        } catch (ClaimNotFoundException_Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //utility method
        public static void printElements(String[] arr) {
            for (String el : arr) {
                System.out.println(el);
            }
        }
}


