<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
        crossorigin="anonymous"></script>
    <title>Animal List</title>
</head>

<body style="background-color: lightgrey;">
    <!-- Begin Nav Bar -->
    <nav class="navbar navbar-expand-lg" style="background-color: rgb(240, 192, 255);">

        <div class="container-fluid">

            <a class="navbar-brand" href="#"><b>Sunny Paws Animal Shelter</b></a>

            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link" href="/animals"><button>Home</button></a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/animals/createForm"><button>Upload an Animal</button></a>
                </li>

                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#"><button>Contact Us</button> </a>
                </li>

            </ul>
        </div>
        </div>
    </nav>
    <!-- End Nav Bar -->
    <div class="container" style="margin-top: 15px;">
        <h1>${title}</h1>
        <form action="/animals/name">
            <input type="text" name="key" placeholder="Search By Name &#128270;">
        </form>
        <br> <br>
        <!--Animals Table-->
        <#list animalList?chunk(3) as animalRow>
            <div class="row mb-4">
                <#list animalRow as animal>
                    <div class="col-md-4">
                        <div class="card h-100">
                            <img src="/animalPictures/${(animal.animalPicturePath)!'avatar.png'}" class="card-img-top"
                                style="height: 200px; object-fit: cover;" alt="animal picture">
                            <div class="card-body">
                                <p class="card-text">
                                    <strong>ID:</strong> <a href="/animals/${animal.dogId?c}"
                                        style="color:#000000">${animal.dogId?c}</a><br>
                                    <strong>Name:</strong> ${animal.name}<br>
                                    <strong>Description:</strong> <a href="/animals/description/${animal.description}"
                                        style="color:#000000">${animal.description}</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        </#list>


    </div>
    </div>

</body>

</html>