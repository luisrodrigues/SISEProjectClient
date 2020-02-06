package com.insure.client;

import com.insure.client.gen.*;
import cryptography.Signature;
import exceptions.DocumentTamperedException;

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
import java.util.List;

/*
    use this command: Wsimport.bat -s ..\src -keep -p com.insure.client.gen "http://localhost:8090/claimservice?wsdl"
    to generate server methods
*/

public class Main {
    public static final String INSERT_CLAIM_ID = "Insert claim id: ";
    public static final String INSERT_DOCUMENT_ID = "Insert document id: ";
    public static final String KEYS = "keys/";

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException {

            Signature signature = new Signature();
            String url = "http://localhost:8090/claimservice";
            ClaimDataStoreService dss = new ClaimDataStoreService();
            //docStorage -> Claim data store
            ClaimDataStore docStorage = dss.getClaimDataStorePort();
            ((BindingProvider) docStorage).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

            // [Client code]
            String userId = JOptionPane.showInputDialog("Insert username: ", "user1");
            //client action options
            String[] options = {"create claim", "update claim" , "create document", "read document", "update document",
                    "delete document", "list documents", "simulate document tampering", "exit"};

            // main state variable
            boolean isRunning = true;

        while (isRunning) {
            String expression = (String)JOptionPane.showInputDialog(null, "Insert your action:",
                    "You are " + userId, JOptionPane.QUESTION_MESSAGE, null, options, options[8]);

                switch (expression) {
                    case "create claim":

                        createClaimClient(docStorage, userId);
                        break;

                    case "update claim":

                        updateClaimClient(docStorage);
                        break;

                    case "create document":

                        createDocumentClient(signature, docStorage, userId);
                        break;

                    case "read document":

                        readDocumentClient(signature, docStorage);
                        break;

                    case "update document":

                        updateDocumentClient(signature, docStorage, userId);
                        break;

                    case "delete document":

                        deleteDocumentClient(docStorage, userId);
                        break;

                    case "list documents":

                        listDocumentsClient(docStorage);
                        break;

                    case "simulate document tampering":

                        simulateDocumentTamperingClient(signature, docStorage);
                        break;

                    case "exit":

                        isRunning = false;
                        break;

                    default:
                        break;
                }
        }

    }

    private static void updateDocumentClient(Signature signature, ClaimDataStore docStorage, String userId) {
        int claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
        int documentId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_DOCUMENT_ID));
        String newDocumentContent = JOptionPane.showInputDialog("Insert document content: ");

        try {
            String digitalSignature = signature.generate(newDocumentContent, KEYS +
                    userId + "PrivateKey");
            docStorage.updateDocumentOfClaim(claimId, documentId, newDocumentContent, digitalSignature, userId);
            JOptionPane.showMessageDialog(null, docStorage.readDocumentOfClaim(claimId,
                    documentId));
        } catch (NoSuchAlgorithmException | IOException | InvalidKeySpecException | BadPaddingException
                | InvalidKeyException | IllegalBlockSizeException | ClaimNotFoundException_Exception
                | DocumentNotFoundException_Exception | NotSameUserException_Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static void deleteDocumentClient(ClaimDataStore docStorage, String userId) {
        int claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
        int documentId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_DOCUMENT_ID));

        try {
            docStorage.deleteDocumentOfClaim(claimId, documentId, userId);
            JOptionPane.showMessageDialog(null, docStorage.readDocumentOfClaim(claimId,
                    documentId));
        } catch (ClaimNotFoundException_Exception | DocumentNotFoundException_Exception | NotSameUserException_Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static void updateClaimClient(ClaimDataStore docStorage) {
        int claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
        String newClaimDescription = JOptionPane.showInputDialog("Insert new claim description: ");

        try {
            docStorage.updateClaim(claimId, newClaimDescription);
            JOptionPane.showMessageDialog(null, docStorage.printClaim(claimId));
        } catch (ClaimNotFoundException_Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    private static void simulateDocumentTamperingClient(Signature signature, ClaimDataStore docStorage) {

        int claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
        int documentId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_DOCUMENT_ID));

        try {
            String documentContent = docStorage.readDocumentContentOfClaim(claimId, documentId);
            String documentUser = docStorage.readDocumentUserOfClaim(claimId, documentId);
            String documentSignature = docStorage.readDocumentSignatureOfClaim(claimId, documentId);

            if (!signature.verify(documentContent + "This has been tampered", documentSignature, KEYS + documentUser + "PublicKey")) {
                throw new DocumentTamperedException("Document "+ documentId +"'s contents have been tampered");
            }

            JOptionPane.showMessageDialog(null, docStorage.readDocumentOfClaim(claimId,
                    documentId));
        } catch (ClaimNotFoundException_Exception | DocumentNotFoundException_Exception | NoSuchAlgorithmException
                | IOException | InvalidKeySpecException | BadPaddingException | InvalidKeyException
                | IllegalBlockSizeException | DocumentTamperedException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    private static void listDocumentsClient(ClaimDataStore docStorage) {

        int claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));

        try {
            String listString = "";
            List<Integer> documentKeys = docStorage.getDocumentKeysOfClaim(claimId);

            for (int i = 0; i < documentKeys.size(); i++) {
                listString += "Document{uuid: " + i + ", userId: " + docStorage.readDocumentUserOfClaim(claimId, i) + "}\n";
            }

            if (listString.equals("")) {
                JOptionPane.showMessageDialog(null, "Claim " + claimId + " has no documents!");
            } else {
                JOptionPane.showMessageDialog(null, listString);
            }
        } catch ( ClaimNotFoundException_Exception | HeadlessException
                | DocumentNotFoundException_Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    private static void readDocumentClient(Signature signature, ClaimDataStore docStorage) {
        int claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
        int documentId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_DOCUMENT_ID));

        try {
            String documentContent = docStorage.readDocumentContentOfClaim(claimId, documentId);
            String documentUser = docStorage.readDocumentUserOfClaim(claimId, documentId);
            String documentSignature = docStorage.readDocumentSignatureOfClaim(claimId, documentId);

            if (!signature.verify(documentContent, documentSignature, KEYS + documentUser + "PublicKey")) {
                throw new DocumentTamperedException("Document "+ documentId +"'s contents have been tampered");
            }

            JOptionPane.showMessageDialog(null, docStorage.readDocumentOfClaim(claimId,
                    documentId));
        } catch (ClaimNotFoundException_Exception | DocumentNotFoundException_Exception | NoSuchAlgorithmException
                | IOException | InvalidKeySpecException | BadPaddingException | InvalidKeyException
                | IllegalBlockSizeException | DocumentTamperedException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    private static void createDocumentClient(Signature signature, ClaimDataStore docStorage, String userId) {
        int claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
        int documentType = Integer.parseInt(JOptionPane.showInputDialog("Insert the document type number (1 - Expert " +
                "Report, 2 - Police Report, 3 - Medical Report): "));
        String documentContent = JOptionPane.showInputDialog("Insert document content: ");

        try {
            String digitalSignature = signature.generate(documentContent, KEYS +
                        userId + "PrivateKey");

            int documentId = docStorage.createDocumentOfClaim(claimId, documentType, documentContent, userId,
                            digitalSignature);
            JOptionPane.showMessageDialog(null, docStorage.readDocumentOfClaim(claimId,
                        documentId));
        } catch (NoSuchAlgorithmException | IOException | InvalidKeySpecException | BadPaddingException
                | InvalidKeyException | IllegalBlockSizeException | BadPaddingException_Exception
                | ClaimNotFoundException_Exception | IOException_Exception | IllegalBlockSizeException_Exception
                | InvalidKeyException_Exception | InvalidKeySpecException_Exception
                | InvalidSignatureException_Exception | NoSuchAlgorithmException_Exception
                | DocumentNotFoundException_Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    private static void createClaimClient(ClaimDataStore docStorage, String userId) {
        String claimDescription = JOptionPane.showInputDialog("Insert claim description: ");
        int claimId = docStorage.createClaim(claimDescription, userId);

        try {
            JOptionPane.showMessageDialog(null, docStorage.printClaim(claimId));
        } catch (ClaimNotFoundException_Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}


