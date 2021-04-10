from django.urls import path

from . import views

urlpatterns = [

    # user login process path

    path('register/', views.registerPage, name="register"),
    path('login/', views.loginPage, name="login"),
    path('logout/', views.logoutUser, name="logout"),

    # view access pages

    path('', views.home, name="home"),
    path('dashboard/', views.dashboard, name='dashboard'),
    path('Students/', views.Students, name='Students'),

    # books section

    path('gallery/', views.gallery, name='gallery'),
    path('photo/<str:pk>/', views.viewPhoto, name='photo'),
    path('add/', views.addPhoto, name='add'),

]
