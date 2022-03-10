import java.util.ArrayList;

import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
 
class TryCommonMark {
    public static void main(String[] args) {
        
        // Node document = parser.parse("This is *Sparta*");
        // HtmlRenderer renderer = HtmlRenderer.builder().build();
        // System.out.println(renderer.render(document));  // "<p>This is <em>Sparta</em></p>\n"

        Node node = parser.parse("[hi](google.com)\n[bye](google.com)");
        LinkCountVisitor visitor = new LinkCountVisitor();
        node.accept(visitor);
        System.out.println(visitor.links);  // 4

    }
}

class WordCountVisitor extends AbstractVisitor {
    int wordCount = 0;

    @Override
    public void visit(Text text) {
        // This is called for all Text nodes. Override other visit methods for other node types.

        // Count words (this is just an example, don't actually do it this way for various reasons).
        wordCount += text.getLiteral().split("\\W+").length;

        // Descend into children (could be omitted in this case because Text nodes don't have children).
        visitChildren(text);
    }
}

class LinkCountVisitor extends AbstractVisitor {
    int linkCount = 0;
    ArrayList<String> links = new ArrayList<>();
    @Override
    public void visit(Link link){
        if(link.getDestination() != null){
            linkCount++;
            links.add(link.getDestination());
        }
        visitChildren(link);
    }
}