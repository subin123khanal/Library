from django.contrib.auth.decorators import login_required
from django.contrib.auth.models import User
from django.shortcuts import render, redirect
from django.contrib import messages
from django.contrib.auth import authenticate, login, logout

# from another python file import class

from .forms import CreateUserForm
from .models import Category, Photo


# Create your views here.

#Users login, reister, logout and Students Detail

#register part

def registerPage(request):
    if request.user.is_authenticated:
        return redirect('home')
    else:
        form = CreateUserForm()
        if request.method == 'POST':
            form = CreateUserForm(request.POST)
            if form.is_valid():
                form.save()
                user = form.cleaned_data.get('username')
                messages.success(request, 'Account was created for ' + user)

                return redirect('login')

        context = {'form': form}
        return render(request, 'register.html', context)

#login part

def loginPage(request):
    if request.user.is_superuser:
        return redirect('home')
    else:
        if request.method == 'POST':
            username = request.POST.get('username')
            password = request.POST.get('password')

            user = authenticate(request, username=username, password=password)

            if not request.user.is_superuser:
                login(request, user)
                return redirect('home')
            else:
                return redirect('register')
        else:
            messages.info(request, 'Username OR password is incorrect')

        context = {}
        return render(request, 'login.html', context)

#logout part

def logoutUser(request):
    logout(request)
    return redirect('login')

#Students Details

def Students(request):
    Students = User.objects.all()
    return render(request, 'Students.html', {'Students': Students})


@login_required(login_url='login')
def home(request):
    return render(request, 'Index.html', {'home': home})


@login_required(login_url='login')
def dashboard(request):
    category = request.GET.get('category')
    if category is None:
        photos = Photo.objects.all()
    else:
        photos = Photo.objects.filter(category__name=category)

    categories = Category.objects.all()
    context = {'categories': categories, 'photos': photos}
    return render(request, 'dashboard.html', context)


@login_required(login_url='login')
def gallery(request):
    category = request.GET.get('category')
    if category is not None:
        photos = Photo.objects.filter(category__name=category)
    else:
        photos = Photo.objects.all()

    context = {'photos': photos}
    return render(request, 'gallery.html', context)


@login_required(login_url='login')
def viewPhoto(request, pk):
    photo = Photo.objects.get(id=pk)
    Categories = Category.objects.get(id=pk)
    return render(request, 'photo.html', {'photo': photo, 'Categories': Categories})


@login_required(login_url='login')
def addPhoto(request):
    categories = Category.objects.all()

    if request.method == 'POST':
        data = request.POST
        images = request.FILES.getlist('images')

        if data['category'] != 'none':
            category = Category.objects.get(id=data['category'])
        elif data['category_new'] != '':
            category, created = Category.objects.get_or_create(
                name=data['category_new'])
        else:
            category = None

        for image in images:
            photo = Photo.objects.create(
                category=category,
                description=data['description'],
                image=image,
            )

        return redirect('gallery')

    context = {'categories': categories}
    return render(request, 'add.html', context)




# next
