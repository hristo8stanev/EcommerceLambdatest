package website.pages.blogarticlepage;

import core.baseassertions.BaseAssertions;
import core.basemap.BaseMap;
import core.basepage.WebPage;

import static urls.Urls.BLOG_ARTICLE_PAGE;

public class BlogArticlePage extends WebPage<BaseMap, BaseAssertions<BaseMap>> {

    @Override
    protected String Url() {
        return BLOG_ARTICLE_PAGE;
    }
}
