package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import java.io.File;

import javax.activation.MimetypesFileTypeMap;

import javafx.scene.image.Image;

/**
 * Represents a Person's photo in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPhoto(String)}
 */
public class Photo {

    public static final String MESSAGE_IMAGE_CONSTRAINTS =
            "Not a valid image file";

    //    public String filePath="/photos/default.jpeg";
    private String filePath;

    public Photo(String filePath) {
        if (filePath == null) {
            filePath = "";
        }
        requireNonNull(filePath);
        this.filePath = filePath;
    }

    /**
     * Returns true if a given string is a valid person photo.
     */
    public static boolean isValidPhoto(String test) {
        File f = new File(test);
        String mimetype = new MimetypesFileTypeMap().getContentType(f);
        String type = mimetype.split("/")[0];
        return type.equals("image");
    }


    @Override
    public String toString() {
        return filePath;
    }

    public void setPath(String filePath) {
        this.filePath = filePath;
    }

    public String getPath() {
        return filePath;
    }

    public Image getImage() {
        if (filePath.equals("")) {
            filePath = "photos/default.jpeg";
        }
        File file = new File(filePath);
        Image image = new Image(file.toURI().toString());
        return image;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.filePath.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return filePath.hashCode();
    }

}
