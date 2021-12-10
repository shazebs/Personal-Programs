let markup =
    '<nav class="navbar navbar-expand-lg navbar-dark" style="background-color:#4f2fb6;">' +
        '<div class="container-fluid">' +
            '<a class="navbar-brand" href="index.html">GCU</a>' +
            '<button class="navbar-toggler"  type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">' +
                '<span class="navbar-toggler-icon" ></span>' +
            '</button>' +
            '<div class="collapse navbar-collapse" id="navbarNavDropdown">' +
                '<ul class="navbar-nav">' +
                    '<li class="nav-item">' +
                        '<a class="nav-link active" aria-current="page" href="index.html">Home</a>' +
                    '</li>' +
                    '<li class="nav-item">' +
                        '<a class="nav-link" href="tando.html">Course Matrix</a>' +
                    '</li>' +
                    '<li class="nav-item">' +
                        '<a class="nav-link" href="media.html">Media</a>' +
                    '</li>' +
                    '<li class="nav-item">' + 
                        '<a class="nav-link" href="contact.html">Contact Professor</a>' +
                    '</li>' +
                    '<li class="nav-item dropdown">' +
                        '<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">' +
                        'Topics' +
                        '</a>' +
                        '<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">' +
                            '<a class="dropdown-item" href="#topic1" data-toggle="collapse">Topic 1</a>' +
                            '<a class="dropdown-item" href="#topic2" data-toggle="collapse">Topic 2</a>' +
                            '<a class="dropdown-item" href="#topic3" data-toggle="collapse">Topic 3</a>' +
                            '<a class="dropdown-item" href="#topic4" data-toggle="collapse">Topic 4</a>' +
                            '<a class="dropdown-item" href="#topic5" data-toggle="collapse">Topic 5</a>' +
                            '<a class="dropdown-item" href="#topic6" data-toggle="collapse">Topic 6</a>' +
                            '<a class="dropdown-item" href="#topic7" data-toggle="collapse">Topic 7</a>' +
                        '</div>' +
                    '</li>' +
                '</ul>' +
            '</div>' +
        '</div>' +
    '</nav>';

document.write(markup);
