package us.jsand.miaul;

import nu.xom.*;

import java.io.IOException;

public class Miaul {
    public static void main(String[] args) {
        // Declare the score.
        Element score = new Element("score-partwise");
        score.addAttribute(new Attribute("version", "3.0"));

        // Declare the list of parts.
        Element partList = new Element("part-list");
        Element scorePart = new Element("score-part");
        scorePart.addAttribute(new Attribute("id", "P1"));
        Element partName = new Element("part-name");
        partName.appendChild("Music");
        scorePart.appendChild(partName);
        partList.appendChild(scorePart);

        // Declare the first part.
        Element part = new Element("part");
        part.addAttribute(new Attribute("id", "P1"));

        // Declare the first measure.
        Element measure = new Element("measure");
        measure.addAttribute(new Attribute("number", "1"));

        // Declare the attributes of the first measure.
        Element attributes = new Element("attributes");
        Element divisions = new Element("divisions");
        divisions.appendChild("1");
        Element key = new Element("key");
        Element fifths = new Element("fifths");
        fifths.appendChild("0");
        key.appendChild(fifths);
        Element time = new Element("time");
        Element beats = new Element("beats");
        beats.appendChild("4");
        Element beatType = new Element("beat-type");
        beatType.appendChild("4");
        time.appendChild(beats);
        time.appendChild(beatType);
        Element clef = new Element("clef");
        Element sign = new Element("sign");
        sign.appendChild("G");
        Element line = new Element("line");
        line.appendChild("2");
        clef.appendChild(sign);
        clef.appendChild(line);
        attributes.appendChild(divisions);
        attributes.appendChild(key);
        attributes.appendChild(time);
        attributes.appendChild(clef);

        // Declare the notes in the first measure.
        Element note = new Element("note");
        Element pitch = new Element("pitch");
        Element step = new Element("step");
        step.appendChild("C");
        Element octave = new Element("octave");
        octave.appendChild("4");
        pitch.appendChild(step);
        pitch.appendChild(octave);
        Element duration = new Element("duration");
        duration.appendChild("4");
        Element type = new Element("type");
        type.appendChild("whole");
        note.appendChild(pitch);
        note.appendChild(duration);
        note.appendChild(type);
        measure.appendChild(attributes);
        measure.appendChild(note);
        part.appendChild(measure);
        score.appendChild(partList);
        score.appendChild(part);

        Document doc = new Document(score);
        String dtd = "http://www.musicxml.org/dtds/partwise.dtd";
        String publicId = "-//Recordare//DTD MusicXML 3.0 Partwise//EN";
        DocType doctype = new DocType("score-partwise", publicId, dtd);
        doc.insertChild(doctype, 0);

        // serialize dat shit
        try {
            Serializer serializer = new Serializer(System.out, "UTF-8");
            serializer.setIndent(2);
            serializer.setMaxLength(64);
            serializer.write(doc);
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
