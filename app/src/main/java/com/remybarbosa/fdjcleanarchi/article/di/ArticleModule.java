package com.remybarbosa.fdjcleanarchi.article.di;


import com.remybarbosa.fdjcleanarchi.app.di.annotation.ActivityScoped;
import com.remybarbosa.fdjcleanarchi.app.di.annotation.FragmentScoped;
import com.remybarbosa.fdjcleanarchi.article.ArticleActivity;
import com.remybarbosa.fdjcleanarchi.article.ArticleFragment;
import com.remybarbosa.fdjcleanarchi.article.ArticlesFragment;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.ArticleContract;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.ArticlePresenter;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.ArticlesContract;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.ArticlesPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ArticleModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract ArticleFragment articleFragment();

    @ActivityScoped
    @Binds
    abstract ArticleContract.Presenter articlePresenter(ArticlePresenter presenter);


    @Provides
    @ActivityScoped
    static String provideArticleLink(ArticleActivity activity) {
        return activity.getIntent().getStringExtra(ArticleActivity.EXTRA_ARTICLE_LINK);
    }
}
