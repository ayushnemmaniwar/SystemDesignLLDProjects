package DeckOfCards;


import java.util.ArrayList;
import java.util.List;

enum Suite {
    SPADE,HEART,CLUB,DIAMOND;
}

class Card {
    int faceValue;
    Suite suite;

    public Card(int faceValue, Suite suite) {
        this.faceValue = faceValue;
        this.suite = suite;
    }
}
public class main {
    public static void main(String [] args) {
        List<Card> cardList = new ArrayList<>();
        for(Suite suite : Suite.values()) {
            for(int i=1;i<=13;i++) {
                cardList.add(new Card(i,suite));
            }
        }

        for(Card card : cardList) {
            System.out.println(card.faceValue +" "+card.suite);
        }
    }
}

//Suite,facevalue
