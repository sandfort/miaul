package us.jsand.miaul;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class TestMusicXMLReader {

    @Befre
    setUp() {
        MusicXMLReader reader = new MusicXMLReader();
        String res = this.getClass().getResource("/res").toString();

        ObjectFactory factory = new ObjectFactory();

        ScorePartwise score = factory.createScorePartwise();
        PartList parts = factory.createPartList();
        score.setPartList(parts);
        ScorePart scorePart = factory.createScorePart();
        scorePart.setId("P1");
        PartName name = factory.createPartName();
        name.setValue("Part 1");
        scorePart.setPartName(name);
        parts.getPartGroupOrScorePart().add(scorePart);
        Part part = factory.createScorePartwisePart();
        part.setId(scorePart);
        score.getPart().add(part);
        Measure measure = factory.createScorePartwisePartMeasure();
        part.getMeasure().add(measure);
        measure.setNumber("1");
        Attributes attr = factory.createAttributes();
        measure.getNoteOrBackupOrForward().add(attr);
        attr.setDivisions(new BigDecimal(1));
        Key keyOfC = factory.createKey();
        keyOfC.setFifths(new BigInteger("0"));
        attr.getKey().add(keyOfC);
        Time commonTime = factory.createTime();
        commonTime.getTimeSignature().add(factory.createTimeBeats("4"));
        commonTime.getTimeSignature().add(factory.createTimeBeatType("4"));
        attr.getTime().add(commonTime);
        Clef gClef = new Clef();
        attr.getClef().add(gClef);
        gClef.setSign(ClefSign.G);
        gClef.setLine(new BigInteger("2"));
        Note note = factory.createNote();
        measure.getNoteOrBackupOrForward().add(note);
        Pitch pitch = factory.createPitch();
        note.setPitch(pitch);
        pitch.setStep(Step.C);
        pitch.setOctave(4);
        note.setDuration(new BigDecimal(4));
        NoteType type = factory.createNoteType();
        type.setValue("whole");
        note.setType(type);
    }

    @Test
    testRead() {
        ScorePartwise result = reader.read(new FileInputStream(in));
    }
}
