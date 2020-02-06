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
            // userid for the session
            String userId = JOptionPane.showInputDialog("Insert username: ", "user1");
            //client action options
            String[] options = {"create claim", "update claim" , "create document", "read document", "update document",
                    "delete document", "list documents", "simulate document tampering", "exit"};

            // main state variable
            boolean isRunning = true;

        while (isRunning) {
            //main action dropdown with user options
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
        //reading user input
        int claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
        int documentId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_DOCUMENT_ID));
        String newDocumentContent = JOptionPane.showInputDialog("Insert document content: ");

        try {
            // generates new signature
            String digitalSignature = signature.generate(newDocumentContent, KEYS +
                    userId + "PrivateKey");
            // adds new content and signature
            // outputs the newly updated document
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
        //reading user input
        int claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
        int documentId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_DOCUMENT_ID));

        try {
            // deletion action
            docStorage.deleteDocumentOfClaim(claimId, documentId, userId);
        } catch (ClaimNotFoundException_Exception | DocumentNotFoundException_Exception | NotSameUserException_Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static void updateClaimClient(ClaimDataStore docStorage) {
        //reading user input
        int claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
        String newClaimDescription = JOptionPane.showInputDialog("Insert new claim description: ");

        try {
            //updates claim and displays it
            docStorage.updateClaim(claimId, newClaimDescription);
            JOptionPane.showMessageDialog(null, docStorage.printClaim(claimId));
        } catch (ClaimNotFoundException_Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    private static void simulateDocumentTamperingClient(Signature signature, ClaimDataStore docStorage) {
        //reading user input
        int claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
        int documentId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_DOCUMENT_ID));

        try {
            //verifying signature on the client side
            String documentContent = docStorage.readDocumentContentOfClaim(claimId, documentId);
            String documentUser = docStorage.readDocumentUserOfClaim(claimId, documentId);
            String documentSignature = docStorage.readDocumentSignatureOfClaim(claimId, documentId);

            // Messes the content of the document as if it was tampered in the server
            if (!signature.verify(documentContent + "This has been tampered", documentSignature, KEYS + documentUser + "PublicKey")) {
                throw new DocumentTamperedException("Document "+ documentId +"'s contents have been tampered");
            }
            // reads document
            JOptionPane.showMessageDialog(null, docStorage.readDocumentOfClaim(claimId,
                    documentId));
        } catch (ClaimNotFoundException_Exception | DocumentNotFoundException_Exception | NoSuchAlgorithmException
                | IOException | InvalidKeySpecException | BadPaddingException | InvalidKeyException
                | IllegalBlockSizeException | DocumentTamperedException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    private static void listDocumentsClient(ClaimDataStore docStorage) {
        //reading user input
        int claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));

        try {
            //builds a string of document info by reading all of the existing keys inside the claim documentMap
            String listString = "";
            List<Integer> documentKeys = docStorage.getDocumentKeysOfClaim(claimId);
            //only displays the document uui and its creator's userId
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
        //buids a string of document
        int claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
        int documentId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_DOCUMENT_ID));

        try {
            //verifying signature on the client side
            String documentContent = docStorage.readDocumentContentOfClaim(claimId, documentId);
            String documentUser = docStorage.readDocumentUserOfClaim(claimId, documentId);
            String documentSignature = docStorage.readDocumentSignatureOfClaim(claimId, documentId);

            if (!signature.verify(documentContent, documentSignature, KEYS + documentUser + "PublicKey")) {
                throw new DocumentTamperedException("Document "+ documentId +"'s contents have been tampered");
            }
            // reads document
            JOptionPane.showMessageDialog(null, docStorage.readDocumentOfClaim(claimId,
                    documentId));
        } catch (ClaimNotFoundException_Exception | DocumentNotFoundException_Exception | NoSuchAlgorithmException
                | IOException | InvalidKeySpecException | BadPaddingException | InvalidKeyException
                | IllegalBlockSizeException | DocumentTamperedException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    private static void createDocumentClient(Signature signature, ClaimDataStore docStorage, String userId) {
        // reading user input
        int claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
        int documentType = Integer.parseInt(JOptionPane.showInputDialog("Insert the document type number (1 - Expert " +
                "Report, 2 - Police Report, 3 - Medical Report): "));
        String documentContent = JOptionPane.showInputDialog("Insert document content: ");

        try {
            // generates digital signature
            String digitalSignature = signature.generate(documentContent, KEYS +
                        userId + "PrivateKey");
            // the creator of the document is this "session" 's user
            int documentId = docStorage.createDocumentOfClaim(claimId, documentType, documentContent, userId,
                            digitalSignature);
            // reads document
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
        // reading user input
        String claimDescription = JOptionPane.showInputDialog("Insert claim description: ");
        int claimId = docStorage.createClaim(claimDescription, userId);

        try {
            // prints the claim
            JOptionPane.showMessageDialog(null, docStorage.printClaim(claimId));
        } catch (ClaimNotFoundException_Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}


